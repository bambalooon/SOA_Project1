package converter;

import jaxb_katalog.TGatunek;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 30.03.14
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */

@FacesConverter(value="gatunekConverter")
public class TGatunekConverter implements Converter {
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null) {
            return null;
        }
        return TGatunek.fromValue(value);
    }
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String string = null;
        if(value instanceof TGatunek) {
            string = ((TGatunek) value).value();
        }
        return string;
    }
}
