package org.jboss.pnc.buildstage.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Sort;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@Entity
@Table(indexes = {
        @Index(name = "buildId", columnList = "buildId"),
        @Index(name = "buildConfigId", columnList = "buildConfigId"),
        @Index(name = "buildConfigIdbuildStage", columnList = "buildConfigId,buildStage")
})
@Getter
@Setter
public class BuildStageDuration extends PanacheEntity {

    @NotBlank(message = "Build Stage may not be blank")
    public String buildStage;

    public long duration;

    @NotBlank(message = "Build Id may not be blank")
    public String buildId;

    @NotBlank(message = "Build config Id may not be blank")
    public String buildConfigId;

    public String projectId;

    public Instant received;

    public static List<BuildStageDuration> getBuildStagesForBuildId(String buildId) {
        return BuildStageDuration.list("buildId", Sort.by("id"), buildId);
    }
}
