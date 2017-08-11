package spring.mvvm.viewmodel;

import java.util.Map;

import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;

public class InsertFormValidator extends AbstractValidator {

    @Override
    public void validate(ValidationContext ctx) {

        Map<String, Property> beanProps = ctx.getProperties(ctx.getProperty().getBase());
        validateModel(ctx, (String) beanProps.get("model").getValue());
        validateMake(ctx, (String) beanProps.get("make").getValue());
        validateDes(ctx, (String) beanProps.get("description").getValue());
        validatePrice(ctx, (Integer) beanProps.get("price").getValue());
    }

    private void validateModel(ValidationContext ctx, String value) {
        if (value == null) {
            this.addInvalidMessage(ctx, "modelError", "名稱不可空白");
        }
    }

    private void validateDes(ValidationContext ctx, String value) {
        if (value == null) {
            this.addInvalidMessage(ctx, "makeError", "製造商不可空白");
        }
    }

    private void validatePrice(ValidationContext ctx, Integer value) {
        if (value == null) {
            this.addInvalidMessage(ctx, "priceError", "價格不可空白");
        } else if (value <= 0) {
            this.addInvalidMessage(ctx, "priceError", "價格必須 > 0");
        }
    }

    private void validateMake(ValidationContext ctx, String value) {
        if (value == null) {
            this.addInvalidMessage(ctx, "desError", "描述不可空白");
        }
    }

}
