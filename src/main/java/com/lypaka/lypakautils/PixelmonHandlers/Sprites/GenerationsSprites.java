package com.lypaka.lypakautils.PixelmonHandlers.Sprites;

import com.pixelmongenerations.api.pokemon.PokemonSpec;
import com.pixelmongenerations.common.entity.pixelmon.EntityPixelmon;
import com.pixelmongenerations.common.item.ItemPixelmonSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GenerationsSprites {

    public static ItemStack getPixelmonSprite (World world, String pokemonName, int form, String texture, boolean shiny) {

        EntityPixelmon pokemon = PokemonSpec.from(pokemonName).create(world);
        if (form > -1) {

            pokemon.setForm(form);

        }
        if (!texture.equalsIgnoreCase("default")) {

            pokemon.setCustomSpecialTexture(texture);

        }
        pokemon.setShiny(shiny);
        return ItemPixelmonSprite.getPhoto(pokemon);

    }

    public static ItemStack getPixelmonSprite (World world, String pokemonName, int form, boolean shiny) {

        EntityPixelmon pokemon = PokemonSpec.from(pokemonName).create(world);
        pokemon.setForm(form);
        pokemon.setShiny(shiny);
        return ItemPixelmonSprite.getPhoto(pokemon);

    }

    public static ItemStack getPixelmonSprite (World world, String pokemonName, String texture, boolean shiny) {

        EntityPixelmon pokemon = PokemonSpec.from(pokemonName).create(world);
        pokemon.setCustomSpecialTexture(texture);
        pokemon.setShiny(shiny);
        return ItemPixelmonSprite.getPhoto(pokemon);

    }

    public static ItemStack getPixelmonSprite (World world, String pokemonName, boolean shiny) {

        EntityPixelmon pokemon = PokemonSpec.from(pokemonName).create(world);
        pokemon.setShiny(shiny);
        return ItemPixelmonSprite.getPhoto(pokemon);

    }

}
