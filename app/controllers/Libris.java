package controllers;

import java.util.ArrayList;
import java.util.List;

import models.LibrisJsonBean;
import models.SndModel;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;

import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.mvc.Controller;
import play.mvc.Scope.RenderArgs;

public class Libris extends Controller {
	private static Logger logger = Logger.getLogger(Libris.class);
	
	public static String librisEndpoint = "http://libris.kb.se/sparql";
	
	
	/**
	 * REst
	 * @param name
	 */
	public static void findLibrisPerson(String name){
		logger.info("name:" + name);
		
		QueryExecution x = null ;
		try {
		  String query = 
			"\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" +
			
			"SELECT ?person \n" +
			"WHERE {\n" +
			"?person foaf:name \"" + name + "\" .\n" +
			"?person a foaf:Person .\n" +
			"}\n" + "\n" ;
					
		 logger.debug("LibrisEndPoint: " + librisEndpoint);
		 logger.debug("Librisquery: " + query);
		 x = QueryExecutionFactory.sparqlService(librisEndpoint, query);
		 ResultSet results = x.execSelect();	 
		
		 List<LibrisJsonBean> resList = new ArrayList<LibrisJsonBean>() ;
		 while (results.hasNext()) {
			QuerySolution querySolution = (QuerySolution) results.next();
			// Access variables: soln.get("x") ;
		    RDFNode n = querySolution.get("person") ; // "x" is a variable in the query    
		      if ( n.isResource() ) {
		    	  String uri = n.asResource().getURI() ;
		    	  logger.debug("Libris Resource: " + uri )  ;
		    	  LibrisJsonBean tmpBean = new LibrisJsonBean(name, uri) ;
		    	  resList.add(tmpBean) ;
		      } else {
		    	  logger.warn("Fetched libris result was not an uri!!!!" + n.toString());
		      }
		  }
  	 
		 renderArgs.put("librisPersons", resList) ;
		 renderJSON(resList) ; 
				 
		 
		} catch (Exception e) {
			logger.error("Error! " + e.toString() );
			throw e ;
		} finally {
			x.close() ; 
		}
		
	}
	
}
