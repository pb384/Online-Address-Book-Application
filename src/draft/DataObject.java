/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draft;

/**
 *
 * @author Saraff
 */
import java.io.*;
import java.util.*;

public class DataObject implements Serializable{

	protected String message;

	DataObject(){
		message = "";
	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String inMessage){
		message = inMessage;
	}
}
