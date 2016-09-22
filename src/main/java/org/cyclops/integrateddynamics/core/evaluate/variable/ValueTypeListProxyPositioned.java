package org.cyclops.integrateddynamics.core.evaluate.variable;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import org.cyclops.cyclopscore.datastructure.DimPos;
import org.cyclops.cyclopscore.persist.nbt.INBTProvider;
import org.cyclops.cyclopscore.persist.nbt.NBTClassType;
import org.cyclops.integrateddynamics.api.evaluate.variable.IValue;
import org.cyclops.integrateddynamics.api.evaluate.variable.IValueType;

/**
 * A list proxy for a certain position.
 */
public abstract class ValueTypeListProxyPositioned<T extends IValueType<V>, V extends IValue> extends ValueTypeListProxyBase<T, V> implements INBTProvider {

    private DimPos pos;
    private EnumFacing side;

    public ValueTypeListProxyPositioned(String name, T valueType, DimPos pos, EnumFacing side) {
        super(name, valueType);
        this.pos = pos;
        this.side = side;
    }

    @Override
    public void writeGeneratedFieldsToNBT(NBTTagCompound tag) {
        NBTClassType.writeNbt(DimPos.class, "pos", pos, tag);
        NBTClassType.writeNbt(EnumFacing.class, "side", side, tag);
    }

    @Override
    public void readGeneratedFieldsFromNBT(NBTTagCompound tag) {
        this.pos = NBTClassType.readNbt(DimPos.class, "pos", tag);
        this.side = NBTClassType.readNbt(EnumFacing.class, "side", tag);
    }

    protected DimPos getPos() {
        return pos;
    }

    protected void setPos(DimPos pos) {
        this.pos = pos;
    }

    protected EnumFacing getSide() {
        return side;
    }

    protected void setSide(EnumFacing side) {
        this.side = side;
    }
}
