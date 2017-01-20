/**
 */
package playlist.tests;

import junit.textui.TestRunner;

import playlist.PlaylistFactory;
import playlist.VideoMedia;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Video Media</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class VideoMediaTest extends MediaTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(VideoMediaTest.class);
	}

	/**
	 * Constructs a new Video Media test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VideoMediaTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Video Media test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected VideoMedia getFixture() {
		return (VideoMedia)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PlaylistFactory.eINSTANCE.createVideoMedia());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //VideoMediaTest
