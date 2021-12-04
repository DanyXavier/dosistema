package com.dasofte.services;

import com.dasofte.modelos.Directorios;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Singleton
public class UploadFileService {

    private static final String ROOT_DIR = "D:/GRUPOHEREDIA";
    private static final Logger LOG = LoggerFactory.getLogger(UploadFileService.class);

    public UploadFileService() {
        try {
            Path root = Path.of(ROOT_DIR);
            if (!Files.exists(root)){
                Files.createDirectory(root);
                LOG.info("directorio creado");
            }
        }catch (IOException e)
        {
            LOG.info("error en la creacion del directorio",e);
        }
    }

    private String getNombre(InputPart inputPart){
        String[] header = inputPart.getHeaders().getFirst("Content-Disposition").split(";");
        for (String nameHeaderPosition:header){
            if (nameHeaderPosition.trim().startsWith("filename")) {
                String[] names = nameHeaderPosition.split("=");
                return names[1].trim().replaceAll("\"","");
            }
        }
        return "no_filename_found";
    }

    public String guardarArchivo(InputPart inputPart, String dirName) {
        String filename = getNombre(inputPart);

        String fileName = ROOT_DIR+ File.separator+dirName+File.separator+filename;

        try {
            InputStream inputStream = inputPart.getBody(InputStream.class,null);
            Path directory = Paths.get(fileName);

            if (!Files.exists(directory)){
                Files.copy(inputStream, directory, StandardCopyOption.REPLACE_EXISTING);
            }else {

                throw new RuntimeException("el archivo ya existe");
            }
        } catch (IOException e) {
           LOG.info(e.getMessage(),e);
        }
        return filename;
    }
    public File obtenerArchivo(String dirName,String filename){
        String fileName = ROOT_DIR+ File.separator+dirName+File.separator+filename;
        return new File(fileName);
    };
    public Directorios crearDirectorio(Directorios dirname){
        try {
            Path path = Path.of(ROOT_DIR +File.separator+ dirname.directorio);
            if (!Files.exists(path)){
                Files.createDirectory(path);
            }
            return dirname;
        }catch (IOException e)
        {
            LOG.info("error en la creacion del directorio",e);
        }
        return null;
    }
}
