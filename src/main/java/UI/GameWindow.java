package UI;

import POJO.Game;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.List;

import static Backend.DBQueries.getAllGames;

public class GameWindow {
    private JPanel gamePanel;
    private JTable gameInfoTable;

    public GameWindow() {
        String[] columnNames = {"GAME ID",
                "SEASON",
                "TYPE",
                "AWAY TEAM ID",
                "HOME TEAM ID",
                "AWAY GOALS",
                "HOME GOALS"};
        DefaultTableModel model = new DefaultTableModel();
        gameInfoTable.setModel(model);
        model.setColumnIdentifiers(columnNames);
        List<Game> allGames = getAllGames();
        for (Game s : allGames) {
            Object[] o = new Object[7];
            o[0] = s.getGameId();
            o[1] = s.getSeason();
            o[2] = s.getType();
            o[3] = s.getAwayTeamId();
            o[4] = s.getHomeTeamId();
            o[5] = s.getAwayGoals();
            o[6] = s.getHomeGoals();
            model.addRow(o);
        }
    }

    public JPanel getGamePanel() {
        return gamePanel;
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
        gamePanel = new JPanel();
        gamePanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JScrollPane scrollPane1 = new JScrollPane();
        gamePanel.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        gameInfoTable = new JTable();
        scrollPane1.setViewportView(gameInfoTable);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return gamePanel;
    }

}
