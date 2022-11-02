package it.polito.tdp.itunes.model;

import java.util.*;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.itunes.db.ItunesDAO;

public class Model {
	
	ItunesDAO dao;
	Graph<Album, DefaultWeightedEdge> grafo;
	Map<Album,Integer> mapalbum;
	List<Album> vertici;
	
	public void creaGrafo(Integer prezzo) {
		dao=new ItunesDAO();
		grafo=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.vertici=dao.getAlbumByPrice(prezzo);
		Graphs.addAllVertices(this.grafo, this.vertici);
		
	}

	public int nVertici() {
		return this.grafo.vertexSet().size();
	}

	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
}
