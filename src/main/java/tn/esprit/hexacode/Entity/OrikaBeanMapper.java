package tn.esprit.hexacode.Entity;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.generator.JavassistCompilerStrategy;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.unenhance.HibernateUnenhanceStrategy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrikaBeanMapper extends ConfigurableMapper {
    private MapperFactory factory;


    public OrikaBeanMapper() {
        super(false);
        init();
    }

    /**
     * {@inheritDoc}
     */



    private void registerClassMap(Class a, Class b) {
        this.factory.classMap(a, b).mapNulls(true).mapNullsInReverse(true).byDefault().register();
    }

    /**
     * Register class map with fields to exclude
     *
     * @param a
     * @param b
     * @param excludeFields
     */
    private void registerClassMap(Class a, Class b, String... excludeFields) {
        ClassMapBuilder builder = this.factory.classMap(a, b);
        for (String excludeField : excludeFields) {
            builder.exclude(excludeField);
        }
        builder.mapNulls(true).mapNullsInReverse(true).byDefault().register();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) {
        factoryBuilder.compilerStrategy(new JavassistCompilerStrategy());
        factoryBuilder.unenhanceStrategy(new HibernateUnenhanceStrategy());
    }

    /**
     * User Orika to convert entity => DTO / DTO => entity
     *
     * @param from
     * @param toClass
     * @param <T>
     * @param <U>     return
     */
    public <T, U> T convertDTO(U from, Class<T> toClass) {

        if (from == null) {
            return null;
        }

        return map(from, toClass);
    }

    /**
     * User Orika to convert entity => DTO / DTO => entity
     *
     * @param from
     * @param toClass
     * @param <T>
     * @param <U>
     * @return
     */
    public <T, U> List<T> convertListDTO(Iterable<U> from, Class<T> toClass) {

        if (from == null) {
            return null;
        }

        return mapAsList(from, toClass);
    }

    public <T, U> Page<T> convertPageDTO(Page<U> from, Class<T> toClass) {

        if (from == null) {
            return null;
        }

        return from.map(entity -> factory.getMapperFacade().map(entity, toClass));
    }


}
