/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2020 TechReborn
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

package techreborn.blockentity.storage.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import reborncore.common.util.Tank;
import techreborn.init.TRBlockEntities;
import techreborn.init.TRContent;

@Deprecated
public class QuantumTankBlockEntity extends TankUnitBaseBlockEntity {

	// Save
	public QuantumTankBlockEntity() {
		super(TRBlockEntities.QUANTUM_TANK, TRContent.TankUnit.QUANTUM);
	}

	@Override
	public void onBreak(World world, PlayerEntity playerEntity, BlockPos blockPos, BlockState blockState) {
		inventory.clear();
	}

	@Override
	public void tick() {

		if (world.isClient()) {
			return;
		}

		Tank tank = this.getTank();

		ItemStack inputSlotStack = getStack(0).copy();
		ItemStack outputSlotStack = getStack(1).copy();
		inventory.clear();

		world.setBlockState(pos, TRContent.TankUnit.QUANTUM.block.getDefaultState());

		TankUnitBaseBlockEntity tankEntity = (TankUnitBaseBlockEntity) world.getBlockEntity(pos);

		if (tankEntity == null) {
			return;
		}

		tankEntity.setTank(tank);

		tankEntity.setStack(0, inputSlotStack);
		tankEntity.setStack(1, outputSlotStack);
	}
}
