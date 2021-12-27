package com.learn.simpleblog.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author:debug (SteadyJack) wx：debug0868
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse implements Serializable{

    private String fileName;

    private String accessPath;

    private String filePath;

}