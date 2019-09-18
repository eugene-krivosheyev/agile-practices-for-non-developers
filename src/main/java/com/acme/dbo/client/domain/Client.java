package com.acme.dbo.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.annotation.Nullable;
import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel(description = "Entity with personalized information about client")
@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ApiModelProperty(notes = "Unique identification of client", hidden = true)
    @Nullable @PositiveOrZero Long id;

    @ApiModelProperty(notes = "Client login for auth", required = true, example = "admin@email.com")
    @NonNull @Pattern(regexp = "^[a-zA-Z0-9_@\\-\\\\.]+$") @Size(min = 5, max = 128)
    @Column(name = "LOGIN")
    String login;

    @EqualsAndHashCode.Exclude @Nullable @Size(min = 5, max = 128)
    @JsonIgnore
    @ApiModelProperty(notes = "Client secret", example = "749f09bade8aca755660eeb17792da880218d4fbdc4e25fbec279d7fe9f65d70")
    @Column(name = "SECRET")
    String secret;

    @EqualsAndHashCode.Exclude @Nullable
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @Column(name = "SALT")
    String salt;

    @ApiModelProperty(notes = "Date registered client")
    @EqualsAndHashCode.Exclude @Nullable @Past
    @Column(name = "CREATED", insertable = false)
    @JsonIgnore
    Instant created;

    @ApiModelProperty(notes = "Active client login")
    @EqualsAndHashCode.Exclude @Nullable
    @Column(name = "ENABLED", insertable = false)
    @JsonIgnore
    Boolean enabled;
}
