package com.loyola473.project4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class Roof extends HouseComponent {

	@Override
	public void build() {
		System.out.println("      /\\");
		System.out.println("     /  \\");
		System.out.println("    /    \\");
		System.out.println("   /      \\");
		System.out.println("  /        \\");
		System.out.println(" /          \\");
		System.out.println("/____________\\");



	}


}
