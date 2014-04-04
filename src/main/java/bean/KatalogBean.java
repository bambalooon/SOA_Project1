package bean;

import jaxb_katalog.Katalog;
import jaxb_katalog.TEnt;
import jaxb_katalog.TGatunek;
import jaxb_katalog.TZagajnik;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 30.03.14
 * Time: 13:12
 * To change this template use File | Settings | File Templates.
 */

@ManagedBean(name="katalog")
@SessionScoped
public class KatalogBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String katalogXml = "katalog.xml";
    private Katalog katalog;

    public KatalogBean() {
        try {
            InputStream inputStream = Katalog.class.getResourceAsStream(KatalogBean.katalogXml);
            JAXBContext jaxbContext = JAXBContext.newInstance(Katalog.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            katalog = (Katalog) jaxbUnmarshaller.unmarshal(inputStream);
        } catch(JAXBException e) {
            e.printStackTrace();
        }
    }

    public Katalog getKatalog() {
        return katalog;
    }

    public List<TZagajnik> getZagajnik() {
        return katalog.getZagajnik();
    }

    public String removeEntry() {

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String zagajnik = params.get("zagajnik");
        String ent = params.get("ent");
        if(zagajnik==null) {
            return "error.xhtml";
        }
        if(ent==null) {
            katalog.removeZagajnik(Integer.parseInt(zagajnik));
        }
        else {
            katalog.getZagajnik().get(Integer.parseInt(zagajnik)).removeEnt(Integer.parseInt(ent));
        }
        return "katalog.xhtml";
    }

    public String zagajnikControl(ZagajnikBean zagajnikBean) {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        try {
            int pow = zagajnikBean.getPowierzchnia();
            int zagajnikIndex = zagajnikBean.getZagajnikIndex();
            if(zagajnikIndex!=-1) {
                katalog.getZagajnik().get(zagajnikIndex).setPowierzchnia(pow);
            } else {
                TZagajnik zagajnik = new TZagajnik();
                zagajnik.setPowierzchnia(pow);
                katalog.getZagajnik().add(zagajnik);
            }
        } catch(NumberFormatException e) {
            return "error.xhtml";
        }
        return "katalog.xhtml";
    }
    public String entControl(EntBean entBean) {
        int zIndex = entBean.getZagajnikIndex();
        int eIndex = entBean.getEntIndex();
        int zagajnik = entBean.getZagajnik();

        int liczbaSloi = entBean.getLiczbaSloi();
        TGatunek gatunek = entBean.getGatunek();
        String imie = entBean.getImie();


        TEnt ent;
        if((zIndex!=-1) && (eIndex!=-1)) {    //editing
            if(zagajnik!=zIndex) {    //move
                ent = katalog.getZagajnik().get(zIndex).getEnt().remove(eIndex);
                katalog.getZagajnik().get(zagajnik).getEnt().add(ent);
            } else {
                ent = katalog.getZagajnik().get(zIndex).getEnt().get(eIndex);
            }
        }
        else {
            ent = new TEnt();
            katalog.getZagajnik().get(zagajnik).getEnt().add(ent);
        }
        ent.setLiczbaSloi(liczbaSloi);
        ent.setGatunek(gatunek);
        ent.setImie(imie);
        return "katalog.xhtml";
    }
}
