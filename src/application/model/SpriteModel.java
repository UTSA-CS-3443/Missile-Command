package application.model;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**Generic sprite model implementing motion, rendering, and boundary checking.
 *
 * @author Michael Cavazos
 */
public abstract class SpriteModel{
	/**Image file for sprite*/
	private Image image;
	/**Horizontal position of sprite*/
	private double positionX;
	/**Vertical position of sprite*/
    private double positionY;
    /**Horizontal speed of sprite*/
    private double velocityX;
    /**Vertical speed of sprite*/
    private double velocityY;
    /**Width of the image*/
    private double width;
    /**height of the image*/
    private double height;

	public SpriteModel(Image image, int width, int height) {
		this.image = image;
		this.positionX = 0;
        this.positionY = 0;
        this.velocityX = 0;
        this.velocityY = 0;
        this.width = width;
        this.height = height;
	}

	/**Update position of sprite based on current position and speed.*/
    public void update(double time) {
        positionX += velocityX * time;
        positionY += velocityY * time;
    }

    /**Adjust the speed of sprite relative to its current speed.*/
	public void addVelocity(double x, double y)
    {
        velocityX += x;
        velocityY += y;
    }

	/**Draw the sprite on the graphics context at its current position.*/
	public void render(GraphicsContext gc)
    {
        gc.drawImage( image, positionX - width/2, positionY - height/2, width, height);
    }

	/**Get the bounding box of the sprite.*/
    public Rectangle2D getBoundary()
    {
        return new Rectangle2D(positionX - width/2, positionY - height/2, width, height);
    }

    /**Test if two sprites have collided.*/
    public boolean intersects(SpriteModel p)
    {
        return this.getBoundary().intersects( p.getBoundary() );
    }

    /**Sets width of sprite to the value provided.*/
	public void setWidth(int width) {
		this.width = width;
	}

	/**Get the current width of the sprite.*/
	public double getWidth() {
		return width;
	}

	/**Sets height of sprite to the value provided.*/
	public void setHeight(int height) {
		this.height = height;
	}

	/**Get the current width of the sprite.*/
	public double getHeight() {
		return height;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	public void setPosition(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	public double getPositionX() {
			return positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setImage(Image image) {
		this.image = image;
		width = image.getWidth();
		height = image.getHeight();
	}

	public void setVelocity(double x, double y) {
        velocityX = x;
        velocityY = y;
    }

	public double getVelocityX() {
		return velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}
}