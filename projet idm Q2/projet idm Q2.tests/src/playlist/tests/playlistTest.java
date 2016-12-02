/**
 */
package playlist.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import playlist.PlaylistFactory;
import playlist.playlist;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>playlist</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class playlistTest extends TestCase {

	/**
	 * The fixture for this playlist test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected playlist fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(playlistTest.class);
	}

	/**
	 * Constructs a new playlist test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public playlistTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this playlist test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(playlist fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this playlist test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected playlist getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PlaylistFactory.eINSTANCE.createplaylist());
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

} //playlistTest
