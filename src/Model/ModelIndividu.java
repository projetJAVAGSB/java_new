/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Individu;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author orel
 */
public class ModelIndividu extends AbstractTableModel
{
private String[] nomsColonnes = {"Code", "Libellé"};
    private Vector<String[]> rows;

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return nomsColonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return nomsColonnes[column]; 
    }
    
    public void loadDatas(ArrayList<Individu> ticAT)
    {
        rows = new Vector<>();
        for(Individu i : ticAT)
        {
            rows.add(new String[]{String.valueOf(i.getCodeIndividu()),i.getLibelleIndividu()});
        }
        fireTableChanged(null);
    }
}
