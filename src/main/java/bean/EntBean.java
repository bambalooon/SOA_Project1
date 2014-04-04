package bean;

import jaxb_katalog.TEnt;
import jaxb_katalog.TGatunek;
import jaxb_katalog.TZagajnik;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 30.03.14
 * Time: 21:01
 * To change this template use File | Settings | File Templates.
 */

@ManagedBean(name="ent")
@RequestScoped
public class EntBean {
    private int zagajnik;
    private int liczbaSloi=0;
    private TGatunek gatunek;

    private String imie="";
    private int entIndex=-1;
    private int zagajnikIndex=-1;

    public EntBean() {
        Map<String,String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String zagajnik = param.get("zagajnik");
        String ent = param.get("ent");
        KatalogBean katalog = (KatalogBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("katalog");
        if(zagajnik!=null && katalog!=null) {
            try {
                int zIndex = Integer.parseInt(zagajnik);
                if(zIndex>=katalog.getZagajnik().size())
                    throw new ArrayIndexOutOfBoundsException();
                zagajnikIndex = zIndex;
                this.zagajnik = zIndex;
                if(ent!=null) {
                    int eIndex = Integer.parseInt(ent);
                    if(eIndex>=katalog.getZagajnik().get(zIndex).getEnt().size())
                        throw new ArrayIndexOutOfBoundsException();
                    entIndex = eIndex;
                    TEnt tEnt = katalog.getZagajnik().get(zIndex).getEnt().get(eIndex);
                    this.liczbaSloi = tEnt.getLiczbaSloi();
                    this.gatunek = tEnt.getGatunek();
                    this.imie = tEnt.getImie();
                }
            } catch(NumberFormatException e) {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
                } catch(IOException ex) {}  //do nothing.. error page doesn't work
            } catch (ArrayIndexOutOfBoundsException e) {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
                } catch (IOException ex) {} //do nothing.. error page doesn't work
            }
        }
    }

    public List<TGatunek> getGatunki() {
        return Arrays.asList(TGatunek.values());
    }

    public int getZagajnikIndex() {
        return zagajnikIndex;
    }

    public void setZagajnikIndex(int zagajnikIndex) {
        this.zagajnikIndex = zagajnikIndex;
    }
    public int getEntIndex() {
        return entIndex;
    }

    public void setEntIndex(int entIndex) {
        this.entIndex = entIndex;
    }
    public int getZagajnik() {
        return zagajnik;
    }
    public void setZagajnik(int zagajnik) {
        this.zagajnik = zagajnik;
    }

    public int getLiczbaSloi() {
        return liczbaSloi;
    }

    public void setLiczbaSloi(int liczbaSloi) {
        this.liczbaSloi = liczbaSloi;
    }

    public TGatunek getGatunek() {
        return gatunek;
    }

    public void setGatunek(TGatunek gatunek) {
        this.gatunek = gatunek;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }
}
