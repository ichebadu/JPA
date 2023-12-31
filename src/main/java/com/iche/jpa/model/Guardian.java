package com.iche.jpa.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(
                        name = "guardian_email"
                )
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(
                        name = "guardian_mobile"
                )
        )
})
@Data
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
