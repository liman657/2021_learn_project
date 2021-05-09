package test;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import static org.jboss.arquillian.graphene.Graphene.guardAjax;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import controller.*;
import model.*;
import service.*;
import util.*;

/**
 * Test the website with arquillian, drone, and sellium.
 * @author Karl Nicholas.
 *
 */
@RunWith(Arquillian.class)
public class SiteTest {
    private static final String WEBAPP_SRC = "src/main/webapp";
    
    @Deployment(testable = false)
    public static Archive<?> createTestArchive() {

        final PomEquippedResolveStage pom = Maven.resolver().loadPomFromFile("pom.xml");

        return ShrinkWrap.create(WebArchive.class, "jsec.war")
            .addAsLibraries(
                pom.resolve("org.webjars:bootstrap:3.3.7").withoutTransitivity().as(JavaArchive.class)
            )
            .addAsLibraries(
        		pom.resolve("org.webjars:jquery:1.11.1").withoutTransitivity().as(JavaArchive.class)
    		)
            .addClasses(
                    User.class, 
                    Role.class, 
                    UserSessionBean.class, 
                    RoleSingletonBean.class, 
                    Resources.class, 
                    AccountsController.class, 
                    IndexController.class 
            )
            .addAsResource(new File("src/main/resources/META-INF/persistence.xml"), "META-INF/persistence.xml")
            .addAsResource(new File("src/main/resources/META-INF/create-script.sql"), "META-INF/create-script.sql")
            .addAsResource(new File("src/main/resources/META-INF/drop-script.sql"), "META-INF/drop-script.sql")
            .addAsResource(new File("src/main/resources/META-INF/load-script.sql"), "META-INF/load-script.sql")
            .addAsResource(new File("src/main/resources/ValidationMessages.properties"), "ValidationMessages.properties")
            .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class)
                    .importDirectory(WEBAPP_SRC).as(GenericArchive.class),
                    "/", Filters.include(".*\\.xhtml$"))
            .addAsWebResource(new File(WEBAPP_SRC, "resources/img/javaee-bs.png"), "resources/img/javaee-bs.png")
            .addAsWebInfResource(new File(WEBAPP_SRC, "WEB-INF/beans.xml"))
            .addAsWebInfResource(new File(WEBAPP_SRC, "WEB-INF/faces-config.xml"))
            .addAsWebInfResource(new File(WEBAPP_SRC, "WEB-INF/jboss-web.xml"))
            .setWebXML(new File(WEBAPP_SRC, "WEB-INF/web.xml"))
            ;
    }

    @Inject
    Logger log;
    
    @Drone
    private WebDriver browser;

    @Test
    public void testRegister() throws Exception {
    	browser.manage().window().setSize(new Dimension(800,600));
    	// only one user should be registered
        browser.get(deploymentUrl.toExternalForm() + "");
        guardAjax(showUserCountButton).click();
        assertEquals("There are 1 users", numberOfUsers.getText().trim());
        
        // login should fail
        // browser.get(deploymentUrl.toExternalForm() + "views/accounts/accounts.xhtml");
        guardHttp(accountButton).click();
        loginsignupEmail.sendKeys("karl@karl.com");
        loginsignupPassword.sendKeys("1234");
        guardHttp(loginButton).click();
        assertEquals("Login Failed!", loginsignupMessages.getText().trim());

        // register a new user
        // browser.get(deploymentUrl.toExternalForm() + "views/accounts/register.xhtml");
        // go through error case first
        guardHttp(toRegisterButton).click();
        registerEmail.sendKeys("");
        registerPassword.sendKeys("");
        registerFirstName.sendKeys("");
        registerLastName.sendKeys("");
        guardHttp(registerButton).click();
        assertEquals("Email Required", helpforemailMessage.getText().trim());
        assertEquals("Password Required", helpforpasswordMessage.getText().trim());

        // go through error case first
        registerEmail.sendKeys("karl@karl.com");
        registerPassword.sendKeys("1234");
        registerFirstName.sendKeys("Karl");
        registerLastName.sendKeys("Nicholas");
        guardHttp(registerButton).click();
        assertEquals("Registration Successful!", detailMessages.getText().trim());

        // update details, from /views/accounts/accounts.xhtml
        userdetailFirstName.clear();
        userdetailFirstName.sendKeys("Karl");
        userdetailLastName.clear();
        userdetailLastName.sendKeys("Nicholas");
        guardHttp(updateButton).click();
        assertEquals("User Info Updated", detailMessages.getText().trim());

        // now two users should be registered
        // browser.get(deploymentUrl.toExternalForm() + "views/index.xhtml");
        guardHttp(homeButton).click();
        assertEquals("Welcome", welcomeMessage.getText().trim());
        assertEquals("Karl.", welcomeUserMessage.getText().trim());
        guardAjax(showUserCountButton).click();
        assertEquals("There are 2 users", numberOfUsers.getText().trim());

        // logout
        // browser.get(deploymentUrl.toExternalForm() + "views/accounts/accounts.xhtml");
        guardHttp(accountButton).click();
        guardHttp(logoutButton).click();
        
        // attempt to bypass security to change password
        browser.get(deploymentUrl.toExternalForm() + "views/accounts/user/changepassword.xhtml");
        assertTrue(loginSubmitButton.isDisplayed());
        // first login with j_security login form
        loginJ_username.sendKeys("karl@karl.com");
        loginJ_password.sendKeys("1234");
        guardHttp(loginSubmitButton).click();
        // then test change password error
        changepasswordPassword.sendKeys("");
        changepasswordConfirmPassword.sendKeys("");
        guardHttp(updatePasswordButton).click();
        assertEquals("Password Required", changepasswordhelpMessage.getText().trim());
        // then test change password error
        changepasswordPassword.sendKeys("1234");
        changepasswordConfirmPassword.sendKeys("12345");
        guardHttp(updatePasswordButton).click();
        assertEquals("Passwords Must Match", passwordmatchMessage.getText().trim());
        // then change password
        changepasswordPassword.sendKeys("1234");
        changepasswordConfirmPassword.sendKeys("1234");
        guardHttp(updatePasswordButton).click();
        assertEquals("Password Updated", detailMessages.getText().trim());
        
        // logout from account page
        guardHttp(logoutButton).click();

        // login should fail
        // browser.get(deploymentUrl.toExternalForm() + "views/accounts/accounts.xhtml");
        // guardHttp(accountButton).click();
        loginsignupEmail.sendKeys("admin@test.com");
        loginsignupPassword.sendKeys("admin");
        guardHttp(loginButton).click();
        assertTrue(adminButton.isDisplayed());

        // perform admin functions on user
        // browser.get(deploymentUrl.toExternalForm() + "views/accounts/admin/admin.xhtml");
        guardHttp(adminButton).click();
        guardHttp(promoteButton).click();
        assertEquals("User promoted to administrator", adminMessages.getText().trim());
        guardHttp(demoteButton).click();
        assertEquals("User demoted to user only", adminMessages.getText().trim());
        guardHttp(removeButton).click();
        assertEquals("User removed", adminMessages.getText().trim());

        // logout
        // browser.get(deploymentUrl.toExternalForm() + "views/accounts/accounts.xhtml");
        guardHttp(accountButton).click();
        guardHttp(logoutButton).click();

        // only one user should be registered
        guardHttp(homeButton).click();
        guardAjax(showUserCountButton).click();
        assertEquals("There are 1 users", numberOfUsers.getText().trim());
        
        // done
    }

    @ArquillianResource private URL deploymentUrl;

    // header tabs
    @FindBy(id = "headerTabHome") private WebElement homeButton;
    @FindBy(id = "headerTabAccount") private WebElement accountButton;
    
    // index page
    @FindBy(id = "indexForm:welcomeMessage") private WebElement welcomeMessage;
    @FindBy(id = "indexForm:welcomeUserMessage") private WebElement welcomeUserMessage;
    @FindBy(id = "indexForm:showUserCount") private WebElement showUserCountButton;
    @FindBy(id = "indexForm:numberOfUsers") private WebElement numberOfUsers;
    
    // account page/loginsignup fragment
    @FindBy(id = "loginsignupForm:login") private WebElement loginButton;
    @FindBy(id = "loginsignupForm:toRegister") private WebElement toRegisterButton;
    @FindBy(id = "loginsignupForm:email") private WebElement loginsignupEmail;
    @FindBy(id = "loginsignupForm:password") private WebElement loginsignupPassword;
    @FindBy(name = "loginsignupForm:messages") private WebElement loginsignupMessages;

    // Register Page
    @FindBy(id = "registerForm:email") private WebElement registerEmail;
    @FindBy(id = "registerForm:password") private WebElement registerPassword;
    @FindBy(id = "registerForm:firstName") private WebElement registerFirstName;
    @FindBy(id = "registerForm:lastName") private WebElement registerLastName;
    @FindBy(id = "registerForm:register") private WebElement registerButton;
    @FindBy(id = "registerForm:helpforemail") private WebElement helpforemailMessage;
    @FindBy(id = "registerForm:helpforpassword") private WebElement helpforpasswordMessage;
    
    // userdetail Page
    @FindBy(id = "userdetailForm:firstName") private WebElement userdetailFirstName;
    @FindBy(id = "userdetailForm:lastName") private WebElement userdetailLastName;
    @FindBy(id = "userdetailForm:logout") private WebElement logoutButton;
    @FindBy(id = "userdetailForm:update") private WebElement updateButton;
    @FindBy(id = "userdetailForm:admin") private WebElement adminButton;
    @FindBy(name = "userdetailForm:messages") private WebElement detailMessages;

    // j_security login Page
    @FindBy(id = "j_username") private WebElement loginJ_username;
    @FindBy(id = "j_password") private WebElement loginJ_password;
    @FindBy(id = "submit") private WebElement loginSubmitButton;

    // changepassword Page
    @FindBy(id = "changepasswordForm:password") private WebElement changepasswordPassword;
    @FindBy(id = "changepasswordForm:confirmPassword") private WebElement changepasswordConfirmPassword;
    @FindBy(id = "changepasswordForm:updatePassword") private WebElement updatePasswordButton;
    @FindBy(id = "changepasswordForm:helpforpassword") private WebElement changepasswordhelpMessage;
    @FindBy(name = "changepasswordForm:messages") private WebElement passwordmatchMessage;

    // admin Page
    @FindBy(id = "adminForm:users:1:promote") private WebElement promoteButton;
    @FindBy(id = "adminForm:users:1:demote") private WebElement demoteButton;
    @FindBy(id = "adminForm:users:1:remove") private WebElement removeButton;
    @FindBy(name = "adminForm:messages") private WebElement adminMessages;
}
