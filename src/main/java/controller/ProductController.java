package controller;

import entity.Product;
import model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProductController extends HttpServlet {
    private ProductModel model = new ProductModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> list = model.getList();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/product/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public static void main(String[] args) {
            ArrayList<Product> list = new ArrayList<>();
            list.add(new Product(1, "1000", "anh1"));
            list.add(new Product(2, "2000", "anh2"));
            list.add(new Product(3, "3000", "anh3"));
            list.add(new Product(4, "4000", "anh4"));
            list.add(new Product(5, "5000", "anh5"));
            list.add(new Product(6, "6000", "anh6"));
            list.add(new Product(7, "7000", "anh7"));
            list.add(new Product(8, "8000", "anh8"));
            list.add(new Product(9, "9000", "anh9"));
            list.add(new Product(10, "11000", "anh10"));
        System.out.println("Các phần tử có trong arrListString là: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
        }

}
