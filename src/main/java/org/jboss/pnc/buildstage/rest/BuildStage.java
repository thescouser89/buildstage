package org.jboss.pnc.buildstage.rest;

import org.jboss.pnc.buildstage.model.BuildStageDuration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class BuildStage {

    @GET
    @Path("/build_id/{buildId}")
    public List<BuildStageDuration> getBuildStagesForBuildId(@PathParam("buildId") String buildId) {
        return BuildStageDuration.getBuildStagesForBuildId(buildId);
    }
}
