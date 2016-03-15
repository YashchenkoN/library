package test.task.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.stereotype.Service;
import test.task.library.converter.UserDTOtoUserConverter;

/**
 * @author Nikolay Yashchenko
 */
@Service(value = "conversionService")
public class ConversionService extends ConversionServiceFactoryBean {

    @Autowired
    private UserService userService;

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        ConverterRegistry converterRegistry = (ConverterRegistry) getObject();
        converterRegistry.addConverter(new UserDTOtoUserConverter(userService));
    }
}
