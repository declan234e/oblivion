package dev.declan234e.oblivion.util;

import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;

public class CustomProperties {

    public static final BooleanProperty ACTIVE = BooleanProperty.of("active");
    public static final IntProperty RODS = IntProperty.of("rods", 0, 4);


}
