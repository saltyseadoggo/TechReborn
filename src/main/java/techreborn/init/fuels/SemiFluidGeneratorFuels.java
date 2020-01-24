/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2018 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package techreborn.init.fuels;

import reborncore.api.praescriptum.fuels.FuelHandler;

import techreborn.api.generator.EFluidGenerator;
import techreborn.api.generator.FluidGeneratorRecipeList;
import techreborn.api.generator.GeneratorRecipeHelper;
import techreborn.api.recipe.Fuels;
import techreborn.init.ModFluids;
import techreborn.init.recipes.RecipeMethods;

/**
 * @author estebes
 */
public class SemiFluidGeneratorFuels extends RecipeMethods {
    public static void init() {
        Fuels.semiFluidGenerator = new FuelHandler("SemiFluidGenerator");

        Fuels.semiFluidGenerator.addFuel()
                .addFluidSource(ModFluids.BIO_FUEL)
                .withEnergyOutput(6.0D)
                .withEnergyPerTick(8.0D)
                .register();

        Fuels.semiFluidGenerator.addFuel()
                .addFluidSource(ModFluids.LITHIUM)
                .withEnergyOutput(60.0D)
                .withEnergyPerTick(8.0D)
                .register();

        Fuels.semiFluidGenerator.addFuel()
                .addFluidSource(ModFluids.OIL)
                .withEnergyOutput(16.0D)
                .withEnergyPerTick(8.0D)
                .register();

        Fuels.semiFluidGenerator.addFuel()
                .addFluidSource(ModFluids.SODIUM)
                .withEnergyOutput(30.0D)
                .withEnergyPerTick(8.0D)
                .register();
    }

    public static void postInit() {
        FluidGeneratorRecipeList recipeList = GeneratorRecipeHelper.getFluidRecipesForGenerator(EFluidGenerator.SEMIFLUID);

        if (recipeList != null) {
            recipeList.getRecipes().forEach(recipe -> Fuels.semiFluidGenerator.addFuel()
                    .addFluidSource(recipe.getFluid())
                    .withEnergyOutput(recipe.getEnergyPerMb())
                    .withEnergyPerTick(8.0D)
                    .register());
        }
    }
}