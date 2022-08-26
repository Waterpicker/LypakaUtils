package com.lypaka.lypakautils.PixelmonHandlers.Sprites;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.PokemonSpec;
import com.pixelmonmod.pixelmon.items.ItemPixelmonSprite;
import net.minecraft.item.ItemStack;

public class ReforgedSprites {

    public static ItemStack getPixelmonSprite (String pokemonName, int form, String texture, boolean shiny) {

        Pokemon pokemon = PokemonSpec.from(pokemonName).create();
        if (form > -1) {

            pokemon.setForm(form);

        }
        if (!texture.equalsIgnoreCase("default")) {

            pokemon.setCustomTexture(texture);

        }
        pokemon.setShiny(shiny);
        return ItemPixelmonSprite.getPhoto(pokemon);

    }

    public static ItemStack getPixelmonSprite (String pokemonName, int form, boolean shiny) {

        Pokemon pokemon = PokemonSpec.from(pokemonName).create();
        pokemon.setForm(form);
        pokemon.setShiny(shiny);
        return ItemPixelmonSprite.getPhoto(pokemon);

    }

    public static ItemStack getPixelmonSprite (String pokemonName, String texture, boolean shiny) {

        Pokemon pokemon = PokemonSpec.from(pokemonName).create();
        pokemon.setCustomTexture(texture);
        pokemon.setShiny(shiny);
        return ItemPixelmonSprite.getPhoto(pokemon);

    }

    public static ItemStack getPixelmonSprite (String pokemonName, boolean shiny) {

        Pokemon pokemon = PokemonSpec.from(pokemonName).create();
        pokemon.setShiny(shiny);
        return ItemPixelmonSprite.getPhoto(pokemon);

    }

}
