package com.demoqa.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MyArgumentsProvider implements ArgumentsProvider {


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                arguments("Vera Voys","voys@gm.com","London"),
                arguments("Vera1 Voys","voys@gm.com","London"),
                arguments("Vera2 Voys","voys@gm.com","London")
        );
    }
}
