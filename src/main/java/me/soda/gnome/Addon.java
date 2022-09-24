package me.soda.gnome;

import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;

public class Addon extends MeteorAddon {

    public static final Category CATEGORY = new Category("Gnome");

    @Override
    public void onInitialize() {
        Modules modules = Modules.get();
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "me.soda.gnome";
    }
}
