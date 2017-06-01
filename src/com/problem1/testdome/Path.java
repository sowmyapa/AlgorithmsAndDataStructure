package com.problem1.testdome;

import java.util.StringTokenizer;

/**
 * Created by sowmyaparameshwara on 5/5/17.
 */
public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void cd(String newPath) {
        String[] newPathArray = newPath.split("/");
        for(String value : newPathArray){
            if(value.equals("..")){
               int index = path.lastIndexOf("/");
               path=path.substring(0,index);
            }else{
                path=path+"/"+value;
            }
        }
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("../x");
        System.out.println(path.getPath());
    }
}
