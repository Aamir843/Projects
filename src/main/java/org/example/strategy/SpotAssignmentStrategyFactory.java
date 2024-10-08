package org.example.strategy;

import org.example.enums.SpotAssignmentStrategyType;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType type){
        switch(type){
            case NEAREST:
                return new NearestSpotAssignmentStrategy(null);

            case RANDOM:
                return new RandomSpotAssignmentStrategy(null, null);

            default:
                throw new IllegalArgumentException("Unknown strategy type");
        }

    }
}
