package org.bobabots253.Tapioca.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;

import java.util.HashSet;
import java.util.Set;

public abstract class CommandBase implements Command {
    protected final Set<Subsystem> m_requirements = new HashSet<>();
    
    public CommandBase(Subsystem... requirements) {
        addRequirements(requirements);
    }
    
    /**
     * Adds the specified requirements to the command.
     *
     * @param requirements the requirements to add.
     */
    public final void addRequirements(Subsystem... requirements) {
        m_requirements.addAll(Set.of(requirements));
    }
    
    @Override
    public final Set<Subsystem> getRequirements() {
        return m_requirements;
    }
}
