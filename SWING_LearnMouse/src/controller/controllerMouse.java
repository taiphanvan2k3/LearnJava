package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.viewTool;

public class controllerMouse implements MouseListener,MouseMotionListener{
	private viewTool ViewTool;

	public controllerMouse(viewTool ViewTool) {
		this.ViewTool = ViewTool;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.ViewTool.addClicks();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.ViewTool.enter();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.ViewTool.exit();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.ViewTool.updatePostion(e.getX(), e.getY());
	}
}
