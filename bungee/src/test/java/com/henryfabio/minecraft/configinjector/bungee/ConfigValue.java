package com.henryfabio.minecraft.configinjector.bungee;

import com.henryfabio.minecraft.configinjector.common.annotations.ConfigField;
import com.henryfabio.minecraft.configinjector.common.annotations.ConfigFile;
import com.henryfabio.minecraft.configinjector.common.annotations.TranslateColors;
import com.henryfabio.minecraft.configinjector.common.injector.ConfigurationInjectable;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.function.Function;

/**
 * @author Henry Fábio
 */
@Getter @Accessors(fluent = true)
@ConfigFile("config.yml")
public final class ConfigValue implements ConfigurationInjectable {

    @Getter private static final ConfigValue instance = new ConfigValue();

    @ConfigField("testValue") @TranslateColors private String testValue;
    @ConfigField("testValue2") private int testValue2;
    @ConfigField("testValue3") private boolean testValue3;
    @ConfigField("testValueSection1.testValue4") private String testValue4;
    @ConfigField("testList") @TranslateColors private List<String> testList;

    public static <T> T get(Function<ConfigValue, T> function) {
        return function.apply(instance);
    }

}
