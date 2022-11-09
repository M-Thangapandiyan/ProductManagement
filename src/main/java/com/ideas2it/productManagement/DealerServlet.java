package com.ideas2it.productManagement;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.ideas2it.productManagement.model.Dealer;
import com.ideas2it.productManagement.service.impl.DealerServiceImpl;
import com.ideas2it.productManagement.util.exception.ProductManagementException;

@WebServlet(urlPatterns = { "/InsertDealer", "/getDealers", "/displayDealer", "/deleteDealer", "/getDealer",
		"/updateDealer","/assignDealer" })
public class DealerServlet extends  HttpServlet{
	DealerServiceImpl dealerService = new DealerServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {

		case "/InsertDealer":
			createDealer(request, response);
			break;

		case "/displayDealer":
			try {
				getDealerById(request, response);
			} catch (IOException | ProductManagementException e) {
				e.printStackTrace();
			}
			break;

		case "/deleteDealer":
			try {
				deleteDealerById(request, response);
			} catch (IOException | ProductManagementException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/getDealers":
			try {
				getDealers(request, response);
			} catch (IOException | ProductManagementException e) {
				e.printStackTrace();
			}
			break;

		case "/getDealer":
			try {
				getDealer(request, response);
			} catch (IOException | ProductManagementException e) {
				e.printStackTrace();
			}
			break;

		case "/updateDealer":
			try {
				updateDealerById(request, response);
			} catch (IOException | ProductManagementException e) {
				e.printStackTrace();
			}
			break;
		case "/assignDealer":
			try {
				assignDealer(request, response);
			} catch (IOException | ProductManagementException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	private void getDealers(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ProductManagementException {
		List<Dealer> dealers = dealerService.getDealers();
		HttpSession session = request.getSession();
		session.setAttribute("dealers", dealers);
		response.sendRedirect("getDealers.jsp");
	}

	private void createDealer(HttpServletRequest request, HttpServletResponse response) {
		try {
			dealerService.createDealer(request.getParameter("brand"), request.getParameter("place"));
		} catch (NumberFormatException | ProductManagementException e) {
			e.printStackTrace();
		}
	}
	private void assignDealer(HttpServletRequest request, HttpServletResponse response)
			throws ProductManagementException, IOException {
		List<Dealer> dealers = dealerService.getDealers();
		HttpSession session = request.getSession();
		session.setAttribute("dealers", dealers);
		response.sendRedirect("createProduct.jsp");
	}
	private void deleteDealerById(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, ProductManagementException, IOException {
		boolean isDeleted = dealerService.removeDealerById(Integer.parseInt(request.getParameter("id")));
		HttpSession session = request.getSession();
		session.setAttribute("isDeleted", isDeleted);
		response.sendRedirect("deleteDealer.jsp");
	}

	private void getDealerById(HttpServletRequest request, HttpServletResponse response)
			throws IOException, NumberFormatException, ProductManagementException {
		Dealer dealer = dealerService.getDealerById(Integer.parseInt(request.getParameter("id")));
		HttpSession session = request.getSession();
		session.setAttribute("dealer", dealer);
		response.sendRedirect("getDealer.jsp");
	}

	private void getDealer(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, ProductManagementException, IOException {
		Dealer dealer = dealerService.getDealerById(Integer.parseInt(request.getParameter("id")));
		HttpSession session = request.getSession();
		session.setAttribute("dealer", dealer);
		response.sendRedirect("updateDealer.jsp");
	}

	private void updateDealerById(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, ProductManagementException, IOException {
		Dealer dealer = dealerService.getDealerById(Integer.parseInt(request.getParameter("id")));
		dealer.setCompany(request.getParameter("company"));
		dealer.setLocation(request.getParameter("location"));
		boolean found = dealerService.updateDealerById(dealer);
		HttpSession session = request.getSession();
		session.setAttribute("found", found);
		response.sendRedirect("updateDealer.jsp");
	}
}
