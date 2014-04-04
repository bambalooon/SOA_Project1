package bean;

import jaxb_katalog.TZagajnik;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 30.03.14
 * Time: 18:58
 * To change this template use File | Settings | File Templates.
 */

@ManagedBean(name="zagajnik")
@RequestScoped
public class ZagajnikBean {
    private int powierzchnia=0;
    private int zagajnikIndex=-1;

    public ZagajnikBean() {
        Map<String,String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String zagajnik = param.get("zagajnik");
        KatalogBean katalog = (KatalogBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("katalog");
        if(zagajnik!=null && katalog!=null) {
            try {
                int index = Integer.parseInt(zagajnik);
                if(index>=katalog.getZagajnik().size())
                    throw new ArrayIndexOutOfBoundsException();
                zagajnikIndex = index;
                powierzchnia=katalog.getZagajnik().get(index).getPowierzchnia();
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

    public int getZagajnikIndex() {
        return zagajnikIndex;
    }

    public void setZagajnikIndex(int zagajnikIndex) {
        this.zagajnikIndex = zagajnikIndex;
    }

    public int getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(int powierzchnia) {
        this.powierzchnia = powierzchnia;
    }
}
