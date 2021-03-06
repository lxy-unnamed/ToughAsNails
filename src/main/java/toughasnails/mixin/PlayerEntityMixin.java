/*******************************************************************************
 * Copyright 2021, the Glitchfiend Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package toughasnails.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import toughasnails.api.thirst.ThirstHelper;
import toughasnails.config.ServerConfig;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin
{
    @Inject(method = "causeFoodExhaustion", at = @At("HEAD"))
    protected void onCauseFoodExhaustion(float exhaustion, CallbackInfo ci)
    {
        if (ServerConfig.enableThirst.get())
        {
            ThirstHelper.getThirst((PlayerEntity) (Object) this).addExhaustion(exhaustion);
        }
    }
}
