/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fileupload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author shailendra
 */
@Controller
public class HelloController {
    private static final String UPLOAD_DIRECTORY ="E:\\JAR/upload";
	private static final int THRESHOLD_SIZE     = 1024 * 1024 * 3;  // 3MB
	int  fileCount=1;
	@RequestMapping("index")
	public ModelAndView uploadForm(){
            System.out.println("----upload form-----");
		return new ModelAndView("index");	
	}
	
	@RequestMapping(value="savefile",method=RequestMethod.POST)
	public ModelAndView saveimage( @RequestParam CommonsMultipartFile file,HttpSession session) throws Exception
	{
            System.out.println("------file upload--111111-----");
	DiskFileItemFactory factory = new DiskFileItemFactory();
	factory.setSizeThreshold(THRESHOLD_SIZE);
	factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	 
	ServletFileUpload upload = new ServletFileUpload(factory);
	ServletContext context = session.getServletContext();

	//String uploadPath = context.getRealPath(UPLOAD_DIRECTORY);
        String uploadPath = UPLOAD_DIRECTORY;
	System.out.println("-----------------"+uploadPath);
        System.out.println("-------"+String.valueOf(fileCount));
        session.setAttribute(String.valueOf(fileCount), new File(uploadPath + File.separator + file.getOriginalFilename()));
        fileCount++;
	byte[] bytes = file.getBytes();
	BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(uploadPath + File.separator + file.getOriginalFilename())));
	stream.write(bytes);
	stream.flush();
	stream.close();
	     
	return new ModelAndView("index","filesuccess","File successfully saved!");
	}
        @RequestMapping(value="submitfor",method=RequestMethod.POST)
	public ModelAndView submitFileUpload(HttpSession session) throws Exception{
            System.out.println("---submit for----");
           fileCount--;
            System.out.println("filecount---for submit----"+fileCount);
            
            for(int i=fileCount;i>0;i--){
                System.out.println("-------"+String.valueOf(fileCount));
                File file =(File) session.getAttribute(String.valueOf(fileCount));
                System.out.println("File Name "+file.getName()+" Path "+file.getPath());
                file.delete();
                fileCount--;
                
            }
            return new ModelAndView("index","filesuccess","File successfully upload !");
        }
                
	
}
