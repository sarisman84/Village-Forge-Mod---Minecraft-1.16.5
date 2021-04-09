package com.spyro.spyrosvillagers.block.metalpress;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

@SuppressWarnings("deprecation")
public class MetalPressBlock extends Block {
    //Field info on facing direction for block
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public MetalPressBlock(Properties properties) {
        super(properties);
    }


    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }


    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new MetalPressTileEntity();
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos blockPos, PlayerEntity player, Hand playerHand, BlockRayTraceResult raytraceResult) {
        //Check if you are on the server or not. If you are client side, exit the method.
        if(world.isClientSide){
            return ActionResultType.SUCCESS;
        }
        interactWith(world,blockPos,player);
        return ActionResultType.CONSUME;
    }

    private void interactWith(World world, BlockPos pos, PlayerEntity player){
        TileEntity tileEntity = world.getBlockEntity(pos);
        if(tileEntity instanceof MetalPressTileEntity && player instanceof ServerPlayerEntity){
            MetalPressTileEntity te = (MetalPressTileEntity) tileEntity;
            NetworkHooks.openGui((ServerPlayerEntity) player, te, te::encodeExtraData);
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        //This makes the block face a certain way that the current placer is looking but inverse (so it looks back at you).
        return this.defaultBlockState().setValue(FACING,context.getHorizontalDirection().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, World world, BlockPos blockPos, BlockState newState, boolean isMoving) {
        if(!state.is(newState.getBlock())){
            TileEntity tileEntity = world.getBlockEntity(blockPos);
            if(tileEntity instanceof IInventory){
                InventoryHelper.dropContents(world, blockPos, (IInventory)tileEntity);
                world.updateNeighbourForOutputSignal(blockPos,this);
            }
            super.onRemove(state, world, blockPos, newState, isMoving);
        }
    }

    //rotate method rotates blocks
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    //mirror flips the blocks facing direction
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    //createBLockStateDefition tells what states this block has.
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> blockBuilder) {
        blockBuilder.add(FACING);
    }
}

