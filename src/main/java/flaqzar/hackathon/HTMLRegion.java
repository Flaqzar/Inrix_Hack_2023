package flaqzar.hackathon;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

class HTMLRegion extends Region
{	 
	final WebView view;
	final WebEngine engine;
	 
	public HTMLRegion(String htmlResourcePath)
	{
		this.view = new WebView();
		this.engine = this.view.getEngine();

		this.getStyleClass().add("html");
		
		String htmlFile;
		
		try(InputStream htmlStream = this.getClass().getResourceAsStream(htmlResourcePath))
		{
			htmlFile = new String(htmlStream.readAllBytes(), StandardCharsets.UTF_8);
		}
		catch(IOException e)
		{
			System.out.println("Failed to load resource: " + e.getMessage());
			htmlFile = "";
		}
		
		this.engine.loadContent(htmlFile);
		this.getChildren().add(this.view);
	}

	@Override
	protected void layoutChildren()
	{
		layoutInArea(this.view, 0, 0, this.getWidth(), this.getHeight(), 0, HPos.CENTER, VPos.CENTER);
	}

	@Override
	protected double computePrefWidth(double height)
	{
		return 750;
	}

	@Override
	protected double computePrefHeight(double width)
	{
		return 500;
	}
}