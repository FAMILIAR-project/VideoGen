/**
 */
package playlist.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import playlist.PlaylistFactory;
import playlist.PlaylistModel;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PlaylistModelTest extends TestCase {

	/**
	 * The fixture for this Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaylistModel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PlaylistModelTest.class);
	}

	/**
	 * Constructs a new Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlaylistModelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PlaylistModel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaylistModel getFixture() {
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
		setFixture(PlaylistFactory.eINSTANCE.createPlaylistModel());
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

} //PlaylistModelTest
