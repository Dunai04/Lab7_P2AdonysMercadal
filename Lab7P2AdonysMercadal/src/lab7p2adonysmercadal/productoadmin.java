/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7p2adonysmercadal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void cargarArchivo() {
        Scanner n = null;
        listaProducto = new ArrayList<>();
        if (archivo.exists()) {
            try {
                n = new Scanner(archivo);
                n.useDelimiter(",");
                while (n.hasNextLine()) {
                    String linea = n.nextLine();
                    String[] partes = linea.split(",");
                    if (partes.length == 6) {
                        int id = Integer.parseInt(partes[0]);
                        String nombre = partes[1];
                        int categoria = Integer.parseInt(partes[2]);
                        double precio = Double.parseDouble(partes[3]);
                        int aisle = Integer.parseInt(partes[4]);
                        int bin = Integer.parseInt(partes[5]);
                        listaProducto.add(new Producto(id, nombre, categoria, precio, aisle, bin));
                    }
                }
            } catch (Exception e) {

            }
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
                bw.write(t.getCategory()+",");
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
