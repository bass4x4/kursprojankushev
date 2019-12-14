package UI;

import POJO.GameSkater;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import static Backend.DBQueries.getAllGameSkaters;

public class GameSkaterWindow {
    private JPanel gameSkaterPanel;
    private JTable gameSkaterTable;

    public GameSkaterWindow() {
        String[] columnNames = {"ASSISTS",
                "GAME GOALS",
                "SHOTS",
                "HITS",
                "PENALTY MINUTES",
                "GAME ID",
                "PLAYER ID",
                "TEAM ID"};
        DefaultTableModel model = new DefaultTableModel();
        gameSkaterTable.setModel(model);
        model.setColumnIdentifiers(columnNames);
        List<GameSkater> gameSkaters = getAllGameSkaters();
        for (GameSkater s : gameSkaters) {
            Object[] o = new Object[8];
            o[0] = s.getAssists();
            o[1] = s.getGoals();
            o[2] = s.getShots();
            o[3] = s.getHits();
            o[4] = s.getPenaltyMinutes();
            o[5] = s.getGameId();
            o[6] = s.getPlayerId();
            o[7] = s.getTeamId();
            model.addRow(o);
        }
    }

    public JPanel getGameSkaterPanel() {
        return gameSkaterPanel;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        gameSkaterPanel = new JPanel();
        gameSkaterPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JScrollPane scrollPane1 = new JScrollPane();
        gameSkaterPanel.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        gameSkaterTable = new JTable();
        scrollPane1.setViewportView(gameSkaterTable);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return gameSkaterPanel;
    }
}
