/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7p2adonysmercadal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adony
 */
public class productoadmin {

    private ArrayList<Producto> listaProducto = new ArrayList();
    private File archivo = null;

    public productoadmin(String path) {
        archivo = new File(path);
    }

    public ArrayList<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(ArrayList<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public DefaultTableModel cargarTabla(DefaultTableModel model) throws FileNotFoundException {
        if (!archivo.exists()) {
            throw new FileNotFoundException("El archivo no existe.");
        }

        model.setRowCount(0);

        try (Scanner n = new Scanner(archivo)) {
            while (n.hasNextLine()) {
                String linea = n.nextLine();
                String[] partes = linea.split(",");
                if (partes.length == 6) {
                    model.addRow(partes);
                } else {
                    throw new IllegalStateException("El archivo esta mal estructurado");
                }
            }
        }
        return model;

    }

    public void cargarArchivo() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(archivo.getName()));
        String s;
        while ((s = bf.readLine()) != null) {
            String[] tokens = s.split(",");
            listaProducto.add(new Producto(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5])));
        }
    }
    
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);
            for (Producto t : listaProducto) {
                bw.write(t.getId() + ",");
                bw.write(t.getName() + ",");
                bw.write(t.getCategory() + ",");
                bw.write(t.getPrice() + ",");
                bw.write(t.getAisle() + ",");
                bw.write(t.getBin() + "\n");
            }
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }
}
