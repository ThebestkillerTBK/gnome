package me.soda.gnome;

import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.greemdev.meteor.commands.ClipCommand;
import net.greemdev.meteor.commands.CommandAliasesCommand;
import net.greemdev.meteor.commands.RenameCommand;
import net.greemdev.meteor.commands.VoidCommand;
import net.greemdev.meteor.modules.*;
import net.minecraft.item.Items;


import java.lang.invoke.MethodHandles;
import java.util.Set;

import static net.greemdev.meteor.util.meteor.StarscriptKt.initGStarscript;

public class Gnome extends MeteorAddon {

    public static final Category CATEGORY = new Category("Gnome", Items.LIME_CONCRETE_POWDER.getDefaultStack());

    @Override
    public void onInitialize() {
        Modules modules = new Modules().get();
        Commands commands = new Commands().get();
        modules.add(new AntiChatSpam());
        modules.add(new AutoMessage());
        modules.add(new CommandAliases());
        modules.add(new Dash());
        modules.add(new GameTweaks());
        modules.add(new IgnoreWorldBorder());
        modules.add(new PrivateChat());
        commands.add(new ClipCommand());
        commands.add(new CommandAliasesCommand());
        commands.add(new RenameCommand());
        commands.add(new VoidCommand());
        MeteorClient.EVENT_BUS.registerLambdaFactory("net.greemdev.meteor", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
        initGStarscript();
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
