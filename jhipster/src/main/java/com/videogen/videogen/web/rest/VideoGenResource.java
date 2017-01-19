package com.videogen.videogen.web.rest;

import com.codahale.metrics.annotation.Timed;

import q11.VideoGenLoader;

import java.io.File;

//import q10.VideoGenerator;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGenFactory;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import org.xtext.example.mydsl.videoGen.impl.MandatoryVideoSeqImpl;
import org.xtext.example.mydsl.videoGen.impl.VideoGenFactoryImpl;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping("/api/videogen")
public class VideoGenResource {

    private final Logger log = LoggerFactory.getLogger(VideoGenResource.class);

    private String videoGenPath="src/main/webapp/videogen/";
    private String videoGenFile=Paths.get(videoGenPath,"test.videogen").toString();

   
    @RequestMapping(value = "/regenerate",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public Response regenerate() {

       List<String> playlist=(new q12.VideoGenerator()).generatePlaylistForFile(videoGenFile);

        Response r=new Response();
       r.playlist=playlist;
        return r;

    }
    
    @RequestMapping(value = "/generate",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void generate(@RequestBody PostData data) {
    	VideoGenFactory factory=new VideoGenFactoryImpl();
    	VideoGeneratorModel videoGen=factory.eINSTANCE.createVideoGeneratorModel();
    	
    	List<String> mandatory=data.getMandatory();
    	for(String s : mandatory){
    		EList<VideoSeq> vSeq=videoGen.getVideoseqs();
    		MandatoryVideoSeq v=factory.eINSTANCE.createMandatoryVideoSeq();
    		v.setDescription(factory.eINSTANCE.createVideoDescription());
    		v.getDescription().setLocation(s);
    		vSeq.add(v);

    	}
    	
    	List<String> optional=data.getOptional();
    	for(String s : optional){
    		EList<VideoSeq> vSeq=videoGen.getVideoseqs();
    		OptionalVideoSeq v=factory.eINSTANCE.createOptionalVideoSeq();
    		v.setDescription(factory.eINSTANCE.createVideoDescription());
    		v.getDescription().setLocation(s);
    		vSeq.add(v);

    	}
    	List<Multiple> multiple=data.getMultiple();
    	for(Multiple s : multiple){
    		EList<VideoSeq> vSeq=videoGen.getVideoseqs();
    		AlternativeVideoSeq v=factory.eINSTANCE.createAlternativeVideoSeq();
    		EList<VideoDescription> vDesc=v.getVideodescs();
    		for(String sub: s.subTitles){
    			VideoDescription newVDesc=factory.eINSTANCE.createVideoDescription();
    			newVDesc.setLocation(sub);
    			vDesc.add(newVDesc);
    		}
    		videoGen.getVideoseqs().add(v);
    		

    	}
    	
    	
    	File f=(new File(videoGenFile));
    	System.out.println(f.getAbsolutePath());
    	(new VideoGenLoader()).save(videoGen, f.getAbsolutePath());
    	
    	
    }


    class Response{
    	boolean done=false;
    	List<String> playlist=new ArrayList<>();




		public List<String> getPlaylist() {
			return playlist;
		}
		public void setPlaylist(List<String> playlist) {
			this.playlist = playlist;
		}
		public boolean isDone() {
			return done;
		}
		public void setDone(boolean done) {
			this.done = done;
		}


    }
    

    private static class PostData{
    	List<String> mandatory=new ArrayList<>();

    	List<String> optional=new ArrayList<>();

    	List<Multiple> multiple=new ArrayList<>();

    	public PostData(){
    		
    	}
    	
		public List<String> getMandatory() {
			return mandatory;
		}

		public void setMandatory(List<String> mandatory) {
			this.mandatory = mandatory;
		}

		public List<String> getOptional() {
			return optional;
		}

		public void setOptional(List<String> optional) {
			this.optional = optional;
		}

		public List<Multiple> getMultiple() {
			return multiple;
		}

		public void setMultiple(List<Multiple> multiple) {
			this.multiple = multiple;
		}
    	


    }
    
    private static class Multiple{
    	String title;
    	List<String> subTitles=new ArrayList<>();
    	
    	public Multiple(){
    		
    	}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public List<String> getSubTitles() {
			return subTitles;
		}
		public void setSubTitles(List<String> subTitles) {
			this.subTitles = subTitles;
		}
    	
    }

}
