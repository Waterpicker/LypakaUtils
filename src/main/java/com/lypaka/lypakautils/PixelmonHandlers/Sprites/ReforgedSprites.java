package com.lypaka.lypakautils.PixelmonHandlers.Sprites;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.PokemonSpec;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.items.ItemPixelmonSprite;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ReforgedSprites {

    public static ItemStack getPixelmonSprite (String pokemonName, int form, String texture) {

        Pokemon pokemon = PokemonSpec.from(pokemonName).create();
        if (form > -1) {

            pokemon.setForm(form);

        }
        if (!texture.equalsIgnoreCase("default")) {

            pokemon.setCustomTexture(texture);

        }
        return ItemPixelmonSprite.getPhoto(pokemon);

    }

    public static ItemStack getPixelmonSprite (String pokemonName, int form) {

        Pokemon pokemon = PokemonSpec.from(pokemonName).create();
        pokemon.setForm(form);
        return ItemPixelmonSprite.getPhoto(pokemon);

    }

    public static ItemStack getPixelmonSprite (String pokemonName, String texture) {

        Pokemon pokemon = PokemonSpec.from(pokemonName).create();
        pokemon.setCustomTexture(texture);
        return ItemPixelmonSprite.getPhoto(pokemon);

    }

    public static ItemStack getPixelmonSprite (String pokemonName) {

        Pokemon pokemon = PokemonSpec.from(pokemonName).create();
        return ItemPixelmonSprite.getPhoto(pokemon);

    }

}
