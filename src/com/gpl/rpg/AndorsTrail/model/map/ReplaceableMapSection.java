package com.gpl.rpg.AndorsTrail.model.map;

import com.gpl.rpg.AndorsTrail.model.quest.QuestProgress;
import com.gpl.rpg.AndorsTrail.util.CoordRect;

public final class ReplaceableMapSection {
	public boolean isApplied = false;
	public final CoordRect replacementArea;
	public final MapSection replaceLayersWith;
	public final QuestProgress requireQuestStage;

	public ReplaceableMapSection(
			CoordRect replacementArea,
			MapSection replaceLayersWith,
			QuestProgress requireQuestStage) {
		this.replacementArea = replacementArea;
		this.replaceLayersWith = replaceLayersWith;
		this.requireQuestStage = requireQuestStage;
	}

	public void apply(MapSection dest) {
		dest.replaceLayerContentsWith(replaceLayersWith, replacementArea);
		isApplied = true;
	}
}
