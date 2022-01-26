package controllers.entities;

import dao.DAOStocks;
import entities.Stocks;
import models.ModelStock;

import javax.swing.*;
import java.util.ArrayList;

public class StocksController {

    DAOStocks dao;

    public StocksController(DAOStocks dao) {
        this.dao = dao;
    }

    public JTable fill() {
        ArrayList<Stocks> data = dao.findAll();
        ModelStock model = new ModelStock(data);
        String[] colNames = model.getColNames();
        for (int i = 0; i < colNames.length; i++) {
            model.addColumn(colNames[i]);
        }

        for (int j = 0; j < data.size(); j++) {
            Stocks s = data.get(j);
            Object[] d = new Object[] {
                    s.getStockNum(),
                    s.getMedicNum(),
                    s.getPharNum(),
                    s.getQte()
            };
            model.insertRow(j, d);
        }

        JTable table = new JTable();
        table.setModel(model);
        return table;
    }
}
