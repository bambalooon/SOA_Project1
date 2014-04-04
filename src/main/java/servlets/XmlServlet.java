package servlets;

import bean.KatalogBean;
import jaxb_katalog.Katalog;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 30.03.14
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
public class XmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KatalogBean katalog = (KatalogBean) req.getSession().getAttribute("katalog");
        PrintWriter out = resp.getWriter();
        if(katalog!=null) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Katalog.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.marshal(katalog.getKatalog(), out);
            } catch(JAXBException e) {
                out.println("Error while marshalling!");
            }
        }
        else {
            out.println("Katalog error!");
        }
    }
}
