package net.faintful.mccourse.entity.client;

import net.faintful.mccourse.MCCourseMod;
import net.faintful.mccourse.entity.custom.RaccoonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RaccoonRenderer extends GeoEntityRenderer<RaccoonEntity> {
    public RaccoonRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new RaccoonModel());
    }

    @Override
    public Identifier getTextureLocation(RaccoonEntity entity) {
        return new Identifier(MCCourseMod.MOD_ID, "textures/entity/raccoon/raccoon.png");
    }
}