package com.tapatron.reg;

import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.servlet.ServletModule;

import com.tapatron.reg.common.ClientExceptionMapper;
import com.tapatron.reg.video.GenreResource;
import com.tapatron.reg.video.GenreService;
import com.tapatron.reg.video.MoviesResource;
import com.tapatron.reg.video.MoviesResourceFactory;
import com.tapatron.reg.video.MoviesService;

public class AppModule extends ServletModule {

    @Override
    protected void configureServlets() {
        bind(ClientExceptionMapper.class);
        bind(GenreResource.class).to(GenreService.class);

        install(new FactoryModuleBuilder()
            .implement(MoviesResource.class, MoviesService.class)
            .build(MoviesResourceFactory.class));
    }
}
